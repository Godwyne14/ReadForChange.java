import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Interface to demonstrate abstraction through interfaces
interface DonationViewer {
    void viewAllDonations(Map<String, Integer> userDonations);
}

// Abstract class to demonstrate Abstraction
abstract class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    // Abstract method to enforce implementation in subclasses
    public abstract void displayRole();
}

// Inheritance:
// Subclass for regular users
class RegularUser extends User {
    public RegularUser(String username, String password) {
        super(username, password);
    }

    // Polymorphism: Overriding displayRole() for different user roles
    @Override
    public void displayRole() {
        System.out.println("Role: Regular User");
    }
}

// Subclass for admin users, implements DonationViewer interface
class AdminUser extends User implements DonationViewer {
    public AdminUser(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin User");
    }

    // Admin-specific functionality
    @Override
    public void viewAllDonations(Map<String, Integer> userDonations) {
        System.out.println("\n--- All User Donations ---");
        for (Map.Entry<String, Integer> entry : userDonations.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}

// Article class demonstrating Encapsulation
class Article {
    private final String title;
    private final int fee;
    private final String cause;
    private final String content;

    public Article(String title, int fee, String cause, String content) {
        this.title = title;
        this.fee = fee;
        this.cause = cause;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public int getFee() {
        return fee;
    }

    public String getCause() {
        return cause;
    }

    public String getContent() {
        return content;
    }
}

public class ReadForChange {
    private final Map<String, User> users = new HashMap<>();
    private User loggedInUser = null;
    private double totalDonations = 0;
    private final Map<String, Integer> userDonations = new HashMap<>();
    private final Article[] articles = {
            new Article("Saving the Oceans", 5, "Pollution, Overfishing, Habitat Destruction",
                    """
                            Our oceans are vast and essential to life on Earth, regulating the climate, providing food, and sustaining
                            ecosystems. However, pollution, overfishing, and climate change are taking a significant toll, endangering
                            marine life and the health of our oceans. Plastic pollution is one of the most pressing issues facing our
                            oceans today. Millions of tons of plastic waste end up in the seas each year, killing marine life and
                            disrupting delicate ecosystems. Overfishing poses another severe threat to marine environments, depleting
                            fish stocks and disrupting the balance of ecosystems. Unsustainable fishing methods, such as trawling,
                            destroy habitats and kill non-target species. Climate change is accelerating ocean degradation, causing
                            rising sea temperatures, Ocean acidification, and coral bleaching. These changes have devastating
                            consequences for marine life, particularly coral reefs, which are home to a vast array of species. The 
                            threat to our oceans from climate change calls for urgent global efforts to reduce emissions and protect
                            marine habitats.The health of our oceans is directly tied to the well-being of all life on Earth. By
                            tackling pollution, overfishing, and climate change, we can restore and preserve these invaluable
                            ecosystems for future generations.
                            """),
            new Article("Reforesting Our Planet", 10, "Deforestation",
                    """
                            Forests cover nearly 30% of the Earth's land and play a crucial role in maintaining ecological balance.
                            Forests act as carbon sinks, absorbing large amounts of CO2 from the atmosphere and mitigating the
                            effects of climate change. Reforestation also contributes to preserving biodiversity by restoring
                            natural habitats for wildlife. In addition to environmental benefits, reforestation offers substantial
                            economic advantages.Restoring forests can create jobs in rural areas, support sustainable timber industries,
                            and promote eco-tourism, contributing to a green economy and improving local livelihoods. Reforesting our
                            planet is a powerful solution to the environmental challenges we face today. By taking action to plant trees,
                            restore ecosystems, and promote sustainable forestry practices, we can safeguard the health of our planet for
                            future generations.
                            """),
            new Article("Clean Energy Revolution", 7, "Environmental Degradation, Climate Change",
                    """
                            The transition to clean energy is no longer just an ideal but a necessity for combating climate change.
                            Solar energy is one of the most abundant and cost-effective forms of renewable energy available today.
                            Wind energy is another key player in the clean energy revolution, offering a reliable and clean source
                            of power. Innovations in energy storage and grid technology are essential for making renewable energy
                            more reliable and accessible. Improved battery storage systems and smart grid technologies can store
                            excess energy produced by solar and wind farms, ensuring a steady supply of clean energy even when
                            production fluctuates. The clean energy revolution is transforming the way we power our world, offering
                            a sustainable and eco-friendly alternative to fossil fuels. By embracing solar, wind, and advanced energy
                            storage solutions, we can create a cleaner, more resilient energy system for future generations.
                            """),
            new Article("Preserving Biodiversity", 8, "Ecosystem Stability, Climate Change",
                    """
                            Biodiversity is the variety of life on Earth, from the smallest microorganisms to the largest animals,
                            and it is essential for the health of ecosystems. However, human activities such as deforestation,
                            pollution, and climate change are pushing species to the brink of extinction, making the preservation
                            of biodiversity more urgent than ever. Biodiversity plays a crucial role in supporting ecosystem services,
                            such as pollination, soil fertility, and water purification. These services are vital for food production,
                            clean water, and a stable climate, meaning that biodiversity loss threatens both human well-being and the
                            planets ecological balance. Habitat destruction is one of the leading causes of biodiversity loss. As
                            forests, wetlands, and other natural habitats are cleared for agriculture and urbanization, species lose
                            their homes, and ecosystems are disrupted, making it harder for many species to survive. Conservation
                            efforts, such as establishing protected areas, wildlife corridors, and restoring degraded ecosystems,
                            are critical for maintaining biodiversity. These strategies not only protect endangered species but also
                            help preserve the intricate connections that sustain life on Earth. Protecting biodiversity is not just
                            about saving individual species; its about safeguarding the ecological systems that sustain life. By
                            prioritizing conservation and habitat protection, we can ensure a rich and resilient natural world for
                            future generations.
                            """),
            new Article("Sustainable Agriculture", 6, "Food Security, Social Equity",
                    """
                            As the global population continues to grow, the demand for food is rising, putting pressure on agricultural
                            systems to produce more. Sustainable agriculture offers a way to meet these demands while protecting the
                            environment, improving food security, and ensuring the long-term health of the planets resources. Industrial
                            agriculture, with its heavy reliance on chemical pesticides, synthetic fertilizers, and monoculture farming,
                            is degrading soil health and contributing to water pollution. Sustainable farming practices, such as crop
                            rotation and organic farming, improve soil fertility and reduce environmental harm. Agroecology, which
                            integrates ecological principles into farming, promotes biodiversity and strengthens ecosystems. By using
                            diverse farming methods, agroecology enhances resilience to climate change, reduces reliance on chemical inputs,
                            and fosters more sustainable food systems. Technological innovations in agriculture, such as precision farming
                            and vertical farming, are revolutionizing food production. These methods optimize resource use, reduce waste,
                            and increase yields, making it possible to grow more food using fewer inputs and less land. Sustainable
                            agriculture is crucial for feeding the growing global population while ensuring the health of our planet. By 
                            adopting eco-friendly farming practices and embracing innovative technologies, we can create a food system that
                            is both productive and sustainable for generations to come.
                             """)
    };

    public static void main(String[] args) {
        new ReadForChange().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Read for Change!");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            // Exception handling for non-numeric input
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> login(scanner);
                    case 2 -> signUp(scanner);
                    case 3 -> {
                        System.out.println("Thank you for using Read for Change. Your Contribution maintain the beauty of our Environment!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).validatePassword(password)) {
            loggedInUser = users.get(username);
            System.out.println("Login successful!");
            loggedInUser.displayRole();
            showDashboard(scanner);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void signUp(Scanner scanner) {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try another.");
        } else {
            System.out.print("Are you signing up as an Admin? (yes/no): ");
            String isAdmin = scanner.nextLine();
            User newUser = isAdmin.equalsIgnoreCase("yes")
                    ? new AdminUser(username, password)
                    : new RegularUser(username, password);
            users.put(username, newUser);
            System.out.println("Sign-up successful! You can now log in.");
        }
    }

    private void showDashboard(Scanner scanner) {
        while (true) {
            System.out.println("\nDashboard:");
            System.out.println("1. Browse Articles");
            System.out.println("2. View Donations");
            System.out.println("3. Logout");

            if (loggedInUser instanceof AdminUser) {
                System.out.println("4. View All User Donations (Admin)");
            }

            System.out.print("Choose an option: ");

            // Exception handling for non-numeric input
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> browseArticles(scanner);
                    case 2 -> viewDonations();
                    case 3 -> {
                        loggedInUser = null;
                        System.out.println("Logged out successfully.");
                        return;
                    }
                    case 4 -> {
                        if (loggedInUser instanceof AdminUser admin) {
                            admin.viewAllDonations(userDonations);
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void browseArticles(Scanner scanner) {
        System.out.println("\nAvailable Articles:");
        for (int i = 0; i < articles.length; i++) {
            System.out.println((i + 1) + ". " + articles[i].getTitle() + " - $" + articles[i].getFee() + " ("
                    + articles[i].getCause() + ")");
        }
        System.out.print("Select an article to read (1-" + articles.length + "): ");

        // Exception handling for invalid article choice
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= articles.length) {
                readArticle(articles[choice - 1], scanner);
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void readArticle(Article article, Scanner scanner) {
        System.out.println("\n" + article.getTitle());
        System.out.println("Cause: " + article.getCause());
        System.out.println("Fee: $" + article.getFee());
        System.out.println(article.getContent());
        System.out.println("\n1. Finish Reading");
        System.out.print("Choose an option: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                processDonation(article);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid option.");
        }
    }

    private void processDonation(Article article) {
        totalDonations += article.getFee();
        userDonations.put(loggedInUser.getUsername(),
                userDonations.getOrDefault(loggedInUser.getUsername(), 0) + article.getFee());
        System.out.println("Thank you for your donation of $" + article.getFee() + " to " + article.getTitle() + "!");
    }

    private void viewDonations() {
        System.out.println("\nTotal Donations: $" + totalDonations);
        System.out.println("Your Donations: $" + userDonations.getOrDefault(loggedInUser.getUsername(), 0));
    }
}
