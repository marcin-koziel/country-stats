package ca.marcinkoziel.countrystats.beans;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private CountryType countryType;
    @NonNull
    private PostType postType;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    @Lob
    private String content;
    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime localDateTime;
    @OneToOne(cascade = CascadeType.MERGE)
    private Image image;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "POST_TAGS", joinColumns = @JoinColumn(name = "POST_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    private List<Tag> tags = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private List<Source> sources = new ArrayList<>();

}