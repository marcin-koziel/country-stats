package ca.marcinkoziel.countrystats.controllers;

import ca.marcinkoziel.countrystats.beans.*;
import ca.marcinkoziel.countrystats.repositories.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private SourceRepository sourceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String goToPageLogin(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/login/register")
    public String goToPageRegister(Model model) {
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/login/register_status")
    public String databaseAddUser(@RequestParam String username, @RequestParam String password, @RequestParam String confirm_password, Model model) {

        if (userRepository.existsByUsernameIgnoreCase(username)) {
            model.addAttribute("title", "Register");
            model.addAttribute("status", "taken");
            return "register";
        } else if (!password.equals(confirm_password)) {
            model.addAttribute("title", "Register");
            model.addAttribute("status", "nomatch");
            return "register";
        } else {

            List<GrantedAuthority> authorityList = new ArrayList<>();

            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

            String encodedPassword = passwordEncoder.encode(password);

            User user = new User(username, encodedPassword, authorityList);

            jdbcUserDetailsManager.createUser(user);

            model.addAttribute("title", "Login");
            model.addAttribute("status", "registered");
            return "login";
        }
    }

    @GetMapping("/all-posts")
    public String allPosts(Model model) {

        List<Post> postsData = postRepository.findAll();

        model.addAttribute("title", String.format("All Posts (%d)", postsData.size()));
        model.addAttribute("postsData", postsData);

        return "category";
    }

    @GetMapping("/results")
    public String results(Model model, @RequestParam(value = "tag", required = false) String name) {

        Tag tag = tagRepository.findByNameContainingIgnoreCase(name);
        List<Post> postsData = postRepository.findAllByTags(tag);

        model.addAttribute("title", String.format("Results: %s (%d)", name, postsData.size()));
        model.addAttribute("postsData", postsData);

        return "category";
    }

    @GetMapping("/categories/{name}")
    public String category(Model model, @PathVariable String name) {

        PostType postType = PostType.valueOf(name.toUpperCase());
        List<Post> postsData = postRepository.findAllByPostType(postType);

        String categoryCapitalized = name.substring(0, 1).toUpperCase() + name.substring(1);

        model.addAttribute("title", String.format("Category: %s (%d)", categoryCapitalized, postsData.size()));
        model.addAttribute("postsData", postsData);

        return "category";
    }

    @GetMapping("/admin/posts")
    public String editPosts(Model model) {

        List<Post> postsData = postRepository.findAll();

        model.addAttribute("title", String.format("View Posts (%d)", postsData.size()));
        model.addAttribute("postsData", postsData);

        return "admin/view-posts";
    }

    @GetMapping("/admin/posts/create")
    public String addPost(Model model) {


        List<Source> sources = sourceRepository.findAll();
        Collections.sort(sources, (o1, o2) -> o1.getUrl().compareTo(o2.getUrl()));

        List<PostType> postTypes = Arrays.asList(PostType.values());
        Collections.sort(postTypes, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        List<Tag> tags = tagRepository.findAll();
        Collections.sort(tags, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        model.addAttribute("post", new Post());
        model.addAttribute("countryList", CountryType.values());
        model.addAttribute("categoryList", postTypes);
        model.addAttribute("tagList", tags);
        model.addAttribute("sourceList", sources);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("localTime", LocalTime.now());
        model.addAttribute("title", "Add Post");

        return "admin/view-post";
    }

    @PostMapping("/admin/posts/add")
    public ModelAndView addPost(@ModelAttribute Post post, @RequestParam("localDate") String localDate, @RequestParam("localTime") String localTime) {

        LocalDateTime dateTime = LocalDateTime.parse(localDate + "T" + localTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        post.setLocalDateTime(dateTime);
        post.setImage(imageRepository.findByImagePath(String.format("/images/%s.jpg", post.getPostType().getName().toLowerCase())));

        postRepository.save(post);

        return new ModelAndView("redirect:/admin/posts");
    }

    @GetMapping("/admin/posts/edit/{id}")
    public String editPost(Model model, @PathVariable Long id) {

        Post post = postRepository.findById(id).orElse(null);

        List<Source> sources = sourceRepository.findAll();
        Collections.sort(sources, (o1, o2) -> o1.getUrl().compareTo(o2.getUrl()));

        List<PostType> postTypes = Arrays.asList(PostType.values());
        Collections.sort(postTypes, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        List<Tag> tags = tagRepository.findAll();
        Collections.sort(tags, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        model.addAttribute("post", post);
        model.addAttribute("countryList", CountryType.values());
        model.addAttribute("categoryList", postTypes);
        model.addAttribute("tagList", tags);
        model.addAttribute("sourceList", sources);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("localTime", LocalTime.now());
        model.addAttribute("title", "Edit Post");

        return "admin/view-post";
    }

    @GetMapping("/admin/posts/delete/{id}")
    public ModelAndView deletePost(@PathVariable Long id) {

        postRepository.deleteById(id);

        return new ModelAndView("redirect:/admin/posts");
    }

}