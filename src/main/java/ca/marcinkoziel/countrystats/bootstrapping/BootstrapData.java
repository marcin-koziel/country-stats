package ca.marcinkoziel.countrystats.bootstrapping;

import ca.marcinkoziel.countrystats.beans.*;
import ca.marcinkoziel.countrystats.repositories.ImageRepository;
import ca.marcinkoziel.countrystats.repositories.PostRepository;
import ca.marcinkoziel.countrystats.repositories.SourceRepository;
import ca.marcinkoziel.countrystats.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private SourceRepository sourceRepository;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void run(String... args) throws Exception {

        // Agriculture

        Tag tagPoland = Tag.builder().name(CountryType.POLAND.getName()).build();
        Tag tagAgriculture = Tag.builder().name(PostType.AGRICULTURE.getName()).build();
        Tag tagMining = Tag.builder().name(PostType.MINING.getName()).build();
        Tag tagManufacturing = Tag.builder().name(PostType.MANUFACTURING.getName()).build();
        Tag tagConstruction = Tag.builder().name(PostType.CONSTRUCTION.getName()).build();
        Tag tagUtilities = Tag.builder().name(PostType.UTILITIES.getName()).build();
        Tag tagRetail = Tag.builder().name(PostType.RETAIL.getName()).build();
        Tag tagTransportation = Tag.builder().name(PostType.TRANSPORTATION.getName()).build();
        Tag tagCommunications = Tag.builder().name(PostType.COMMUNICATIONS.getName()).build();
        Tag tagFinance = Tag.builder().name(PostType.FINANCE.getName()).build();
        
        Tag tagCrops = Tag.builder().name("Crops").build();
        Tag tagRevenue = Tag.builder().name("Revenue").build();
        Tag tagBenefits = Tag.builder().name("Benefits").build();
        Tag tagLivestock = Tag.builder().name("Livestock").build();

        tagRepository.saveAll(
                Arrays.asList(
                        tagPoland, tagAgriculture, tagMining, tagManufacturing, tagConstruction,
                        tagUtilities, tagRetail, tagTransportation, tagCommunications, tagFinance,
                        tagCrops, tagRevenue, tagBenefits, tagLivestock
                )
        );
        
        Image imageAgriculture = Image.builder().imagePath("/images/agriculture.jpg").build();
        Image imageMining = Image.builder().imagePath("/images/mining.jpg").build();
        Image imageManufacturing = Image.builder().imagePath("/images/manufacturing.jpg").build();
        Image imageConstruction = Image.builder().imagePath("/images/construction.jpg").build();
        Image imageUtilities = Image.builder().imagePath("/images/utilities.jpg").build();
        Image imageRetail = Image.builder().imagePath("/images/retail.jpg").build();
        Image imageTransportation = Image.builder().imagePath("/images/transportation.jpg").build();
        Image imageCommunications = Image.builder().imagePath("/images/communications.jpg").build();
        Image imageFinance = Image.builder().imagePath("/images/finance.jpg").build();

        imageRepository.saveAll(
            Arrays.asList(
                    imageAgriculture, imageMining, imageManufacturing, imageConstruction, imageUtilities,
                    imageRetail, imageTransportation, imageCommunications, imageFinance
            )
        );

        Source sourceAgriculture1 = Source.builder().url("https://eaap2015.syskonf.pl/agriculture#:~:text=The%20most%20important%20crops%20are,%2C%20poultry%2C%20and%20cultivate%20fruit.").build();
        Source sourceAgriculture2 = Source.builder().url("nationsencyclopedia.com/Europe/Poland-AGRICULTURE.html").build();
        Source sourceAgriculture3 = Source.builder().url("eaap2015.syskonf.pl/agriculture").build();
        Source sourceAgriculture4 = Source.builder().url("https://www.nationsencyclopedia.com/economies/Europe/Poland-AGRICULTURE.html").build();

        Source sourceMining1 = Source.builder().url("en.wikipedia.org/wiki/Coal_in_Poland").build();
        Source sourceMining2 = Source.builder().url("iisd.org/gsi/sites/default/files/poland_casestudy_ffs.pdf").build();

        Source sourceManufacturing1 = Source.builder().url("en.wikipedia.org/wiki/Category:Manufacturing_companies_of_Poland").build();
        Source sourceManufacturing2 = Source.builder().url("investopedia.com/articles/investing/011416/3-economic-challenges-poland-faces-2016.asp").build();

        Source sourceConstruction1 = Source.builder().url("en.wikipedia.org/wiki/Residential_architecture_in_Poland").build();
        Source sourceConstruction2 = Source.builder().url("culture.pl/en/article/building-blocks-polands-most-popular-homes").build();

        Source sourceUtilities1 = Source.builder().url("en.wikipedia.org/wiki/List_of_companies_of_Poland").build();
        Source sourceUtilities2 = Source.builder().url("notesfrompoland.com/2021/12/18/gas-bills-to-rise-54-and-electricity-24-in-new-year-says-says-polish-regulator/").build();

        Source sourceRetail1 = Source.builder().url("https://en.wikipedia.org/wiki/List_of_supermarket_chains_in_Poland").build();
        Source sourceRetail2 = Source.builder().url("https://www.nationsencyclopedia.com/economies/Europe/Poland-RETAIL.html").build();

        Source sourceTransportation1 = Source.builder().url("en.wikipedia.org/wiki/Transport_in_Poland").build();
        Source sourceTransportation2 = Source.builder().url("sidmartinbio.org/what-is-the-main-transportation-in-poland/").build();

        Source sourceCommunications1 = Source.builder().url("en.wikipedia.org/wiki/Telecommunications_in_Poland").build();

        Source sourceFinance1 = Source.builder().url("en.wikipedia.org/wiki/Ministry_of_Finance_(Poland)").build();
        Source sourceFinance2 = Source.builder().url("tradingeconomics.com/poland/government-debt-to-gdp").build();



        Post agriculture1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.AGRICULTURE)
                .title("What crops are grown in Poland?")
                .author("Unknown")
                .content("The most important crops are grains, of which the highest yields came from rye, wheat, barley, and oats. Other major crops are potatoes, sugar beets, fodder crops, flax, hops, tobacco, and fruits. Farms all over Poland raise dairy cows, beef cattle, pigs, poultry, and cultivate fruit.")
                .localDateTime(LocalDateTime.now())
                .image(imageAgriculture)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagAgriculture, tagCrops)))
                .sources(new ArrayList<Source>(List.of(sourceAgriculture1)))
                .build();

        postRepository.save(agriculture1);

        Post agriculture2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.AGRICULTURE)
                .title("What is the average yield for crops in Poland?")
                .author("Unknown")
                .content("In 1999, principal crops and their estimated yields (in thousands of tons) were potatoes, 19,927; sugar beets, 12,554; wheat, 9,051; rye, 5,181; barley, 3,401; and oats, 1,446. Yields have been poor because of infertile soil, insufficient use of fertilizers, and inadequate mechanization, in addition to the drought. There were 1,310,500 tractors in 1997, up from 620,724 during 1979–81. Although grain production has been Poland's traditional agricultural pursuit, since World War II, Poland has become an importer— instead of an exporter—of grains, particularly wheat.")
                .localDateTime(LocalDateTime.now())
                .image(imageAgriculture)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagAgriculture, tagCrops)))
                .sources(new ArrayList<Source>(List.of(sourceAgriculture2)))
                .build();

        postRepository.save(agriculture2);

        Post agriculture3 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.AGRICULTURE)
                .title("What is the most common type of livestock raised in Poland?")
                .author("Unknown")
                .content("In 1999, principal crops and their estimated yields (in thousands of tons) were potatoes, 19,927; sugar beets, 12,554; wheat, 9,051; rye, 5,181; barley, 3,401; and oats, 1,446. Yields have been poor because of infertile soil, insufficient use of fertilizers, and inadequate mechanization, in addition to the drought. There were 1,310,500 tractors in 1997, up from 620,724 during 1979–81. Although grain production has been Poland's traditional agricultural pursuit, since World War II, Poland has become an importer— instead of an exporter—of grains, particularly wheat.")
                .localDateTime(LocalDateTime.now())
                .image(imageAgriculture)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagAgriculture, tagLivestock)))
                .sources(new ArrayList<Source>(List.of(sourceAgriculture3)))
                .build();

        postRepository.save(agriculture3);

        Post agriculture4 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.AGRICULTURE)
                .title("What is the most common type of agriculture practiced in Poland?")
                .author("Unknown")
                .content("Poland is among the world's leading producers of rye, potatoes, and apples, as well as pork and milk. The length of the growing season varies regionally according to climate, being much shorter in the northeast where a harsh continental climate prevails. Although the exports of certain produce (potatoes, apples and other fruits, frozen ducks and geese, and sugar) has declined over the years, Poland exports grains, sugar, pork, processed meats, and dairy products. The upwards of 150-year-old sugar industry faces stiff price competition from overseas producers and is under pressure to restructure itself as the quantities of unsold sugar mount. Similarly, the once enormous potato production has been substantially reduced by changes and improvements to the feeding of livestock. Farmers face tough competition from imported commodities and food products, and are dissatisfied by the lack of sufficient export markets. It is expected that, within a decade, there will be no more than 700,000 farms in Poland. They will be large, specialized, and commercially geared, replacing the small, diversified, but often inefficient agricultural producers. Restructuring of the farming sector is a major issue in negotiating Poland's access to the EU.")
                .localDateTime(LocalDateTime.now())
                .image(imageAgriculture)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagAgriculture, tagCrops, tagLivestock)))
                .sources(new ArrayList<Source>(List.of(sourceAgriculture4)))
                .build();

        postRepository.save(agriculture4);

        // Mining

        Post mining1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.MINING)
                .title("How much revenue does Mining generate in Poland?")
                .author("Marcin K.")
                .content("Mining in Poland generates a significant amount of revenue. In 2017, it was estimated that the industry generated over $1.5 billion in revenue.")
                .localDateTime(LocalDateTime.now())
                .image(imageMining)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagMining, tagRevenue)))
                .sources(new ArrayList<Source>(List.of(sourceMining1)))
                .build();

        postRepository.save(mining1);

        Post mining2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.MINING)
                .title("What are the benefits of Mining in Poland?")
                .author("Marcin K.")
                .content("There are many benefits to mining in Poland. Some of the key benefits include:\n" +
                        "\n" +
                        "1. Low electricity costs - Poland has some of the lowest electricity costs in Europe, making it a very attractive location for mining operations.\n" +
                        "\n" +
                        "2. Access to skilled labor - Poland has a large and skilled labor force, which is perfect for mining operations.\n" +
                        "\n" +
                        "3. Robust infrastructure - Poland has a well-developed infrastructure, which is ideal for supporting mining operations.\n" +
                        "\n" +
                        "4. Political stability - Poland is a politically stable country, which is important for mining operations.")
                .localDateTime(LocalDateTime.now())
                .image(imageMining)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagMining, tagBenefits)))
                .sources(new ArrayList<Source>(List.of(sourceMining2)))
                .build();

        postRepository.save(mining2);

        // Manufacturing

        Post manufacturing1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.MANUFACTURING)
                .title("What are the most common manufacturing processes used in Poland?")
                .author("Marcin K.")
                .content("The most common manufacturing processes used in Poland are machining, casting, and forging.")
                .localDateTime(LocalDateTime.now())
                .image(imageManufacturing)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagManufacturing)))
                .sources(new ArrayList<Source>(List.of(sourceManufacturing1)))
                .build();

        postRepository.save(manufacturing1);

        Post manufacturing2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.MANUFACTURING)
                .title("What are the biggest challenges facing Poland's manufacturing sector?")
                .author("Marcin K.")
                .content("The biggest challenges facing Poland's manufacturing sector are the high cost of labor and the lack of skilled workers.")
                .localDateTime(LocalDateTime.now())
                .image(imageManufacturing)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagManufacturing)))
                .sources(new ArrayList<Source>(List.of(sourceManufacturing2)))
                .build();

        postRepository.save(manufacturing2);

        // Construction

        Post construction1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.CONSTRUCTION)
                .title("How much does it cost to build a house in Poland?")
                .author("Marcin K.")
                .content("The cost of building a house in Poland varies depending on the size and type of house you want to build. However, on average, it costs around $75 per square foot to build a house in Poland.")
                .localDateTime(LocalDateTime.now())
                .image(imageConstruction)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagConstruction)))
                .sources(new ArrayList<Source>(List.of(sourceConstruction1)))
                .build();

        postRepository.save(construction1);

        Post construction2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.CONSTRUCTION)
                .title("What are the most popular construction materials in Poland?")
                .author("Marcin K.")
                .content("The most popular construction materials in Poland are concrete, brick, and wood.")
                .localDateTime(LocalDateTime.now())
                .image(imageConstruction)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagConstruction)))
                .sources(new ArrayList<Source>(List.of(sourceConstruction2)))
                .build();

        postRepository.save(construction2);

        // Utilities

        Post utilities1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.UTILITIES)
                .title("What are the most common Utilities in Poland?")
                .author("Marcin K.")
                .content("The most common Utilities in Poland are water, gas, and electricity.")
                .localDateTime(LocalDateTime.now())
                .image(imageUtilities)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagUtilities)))
                .sources(new ArrayList<Source>(List.of(sourceUtilities1)))
                .build();

        postRepository.save(utilities1);

        Post utilities2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.UTILITIES)
                .title("What are the most expensive Utilities in Poland?")
                .author("Marcin K.")
                .content("The most expensive Utilities in Poland are Electricity and Gas. In 2017, the average price for Electricity was $0.15 per kWh, and the average price for Gas was $7.50 per m3.")
                .localDateTime(LocalDateTime.now())
                .image(imageUtilities)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagUtilities)))
                .sources(new ArrayList<Source>(List.of(sourceUtilities2)))
                .build();

        postRepository.save(utilities2);

        // Retail

        Post retail1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.RETAIL)
                .title("What are the most popular Retail products in Poland?")
                .author("Marcin K.")
                .content("The most popular retail products in Poland vary depending on the region. However, some of the most popular items include clothing, food, and electronics.")
                .localDateTime(LocalDateTime.now())
                .image(imageRetail)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagRetail)))
                .sources(new ArrayList<Source>(List.of(sourceRetail1)))
                .build();

        postRepository.save(retail1);

        Post retail2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.RETAIL)
                .title("What are the most popular Retail shopping destinations in Poland?")
                .author("Marcin K.")
                .content("The most popular retail shopping destinations in Poland vary depending on the region. However, some of the most popular destinations include Warsaw, Krakow, and Poznan.")
                .localDateTime(LocalDateTime.now())
                .image(imageRetail)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagRetail)))
                .sources(new ArrayList<Source>(List.of(sourceRetail2)))
                .build();

        postRepository.save(retail2);

        // Transportation

        Post transportation1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.TRANSPORTATION)
                .title("What are the best ways to get around in Poland?")
                .author("Marcin K.")
                .content("There are a few different ways to get around in Poland. You can drive, take public transportation, or walk. Driving is the most popular way to get around, but it can be expensive. Public transportation is cheaper, but it can be slow and crowded. Walking is the cheapest option, but it can be difficult to get around in some areas.")
                .localDateTime(LocalDateTime.now())
                .image(imageTransportation)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagTransportation)))
                .sources(new ArrayList<Source>(List.of(sourceTransportation1)))
                .build();

        postRepository.save(transportation1);

        Post transportation2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.TRANSPORTATION)
                .title("What are the most expensive transportation options in Poland?")
                .author("Marcin K.")
                .content("The most expensive transportation options in Poland are driving and flying. Driving can be expensive because of the cost of gasoline and tolls. Flying can be expensive because of the cost of airplane tickets.")
                .localDateTime(LocalDateTime.now())
                .image(imageTransportation)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagTransportation)))
                .sources(new ArrayList<Source>(List.of(sourceTransportation2)))
                .build();

        postRepository.save(transportation2);

        // Communications

        Post communications1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.COMMUNICATIONS)
                .title("What is the most common way to communicate with people in Poland?")
                .author("Marcin K.")
                .content("The most common way to communicate with people in Poland is through spoken language. However, there is also a large Polish population that uses English as their main form of communication.")
                .localDateTime(LocalDateTime.now())
                .image(imageCommunications)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagCommunications)))
                .sources(new ArrayList<Source>(List.of(sourceCommunications1)))
                .build();

        postRepository.save(communications1);

        // Finance

        Post finance1 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.FINANCE)
                .title("How does Poland finance its government spending?")
                .author("Marcin K.")
                .content("Poland finances its government spending through a variety of means, including taxes, borrowing, and printing money.")
                .localDateTime(LocalDateTime.now())
                .image(imageFinance)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagFinance)))
                .sources(new ArrayList<Source>(List.of(sourceFinance1)))
                .build();

        postRepository.save(finance1);

        Post finance2 = Post.builder()
                .countryType(CountryType.POLAND)
                .postType(PostType.FINANCE)
                .title("What is Poland's debt to GDP ratio?")
                .author("Marcin K.")
                .content("As of 2017, Poland's debt to GDP ratio was at 47.8%.")
                .localDateTime(LocalDateTime.now())
                .image(imageFinance)
                .tags(new ArrayList<Tag>(Arrays.asList(tagPoland, tagFinance)))
                .sources(new ArrayList<Source>(List.of(sourceFinance2)))
                .build();

        postRepository.save(finance2);


        sourceRepository.saveAll(
                Arrays.asList(
                        sourceAgriculture1, sourceAgriculture2, sourceAgriculture3, sourceAgriculture4,
                        sourceMining1, sourceMining2,   sourceManufacturing1, sourceManufacturing2,
                        sourceConstruction1, sourceConstruction2, sourceUtilities1, sourceUtilities2,
                        sourceRetail1, sourceRetail2, sourceTransportation1, sourceTransportation2,
                        sourceCommunications1, sourceFinance1, sourceFinance2
                )
        );


    }

}
