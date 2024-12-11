# I. Brief Project Overview
ReadForChange is an executable program designed to raise environmental awareness and support sustainable initiatives. Its main purpose is to provide a simple and organized way for users to read articles on environmental issues, contribute through set donation fees, and track their impact. The program aims to make supporting environmental causes convenient and efficient by focusing on usability and automation.
# II. Explanation of how OOP principles were applied
**Encapsulation**  
 - Encapsulation is used in ReadForChange by combining data and methods into a single unit while restricting direct access to private fields. For instance, the Article class encapsulates details like title, fee, and cause, which are accessible only through public getter and setter methods such as getTitle() and setFee(). Similarly, the Donation class secures the userDonations data structure, allowing updates exclusively through the processDonation() method. This ensures sensitive data is protected, prevents unauthorized access, and maintains data consistency across the program.

**Polymorphism**  
- Polymorphism in ReadForChange is demonstrated through method overriding and overloading. For example, the displayRole() method in the User class is overridden by its subclasses AdminUser and RegularUser to provide specific role details AdminUser shows "Role: Admin" while RegularUser shows "Role: Regular". Additionally, the Donation class uses method overloading in the processDonation() method, which has multiple versions: one handles a single donation amount, and another manages donations along with a list of articles. This allows the system to dynamically handle user actions and ensures flexibility in the donation process.

**Inheritance**  
- Inheritance in ReadForChange is implemented using the User class as the base class, from which the AdminUser and RegularUser classes inherit. The User class includes shared attributes like username and password, as well as methods such as validatePassword() and displayRole(). These subclasses extend the base functionality, with AdminUser including features like viewing all donations. This approach eliminates code duplication, creates a modular structure, and allows for easy scalability of new user types.

**Abstraction**  
- Abstraction is applied in ReadForChange to hide complex implementation details while exposing essential functionality. The User class defines abstract methods like validatePassword() and displayRole(), which are implemented differently in the AdminUser and RegularUser subclasses. Similarly, the Donation class abstracts the donation process by exposing methods like processDonation(), while concealing how the donation details are stored and updated. This approach simplifies user interaction, making the program intuitive while managing underlying complexity internally.
# III. SDG and Its Integration into the Project
**Quality Education**  
- ReadForChange ensures that everyone has access to high-quality, inclusive education by making it easy for users to learn about environmental issues. The system promotes lifelong learning opportunities by providing readers with articles on sustainability, empowering them to deepen their understanding of global challenges. By engaging with this educational content, users are encouraged not only to learn but also to take action through donations. Additionally, the platform is accessible to all, fostering an environment where anyone can contribute to environmental protection and sustainability.

**Economic Growth and Decent Work**  
- ReadForChange promotes economic growth and decent work by providing users with an impactful way to support sustainability projects. The system enables individuals to donate to green initiatives by simply reading articles, empowering them to support causes that create employment opportunities in the environmental sector. This digital platform helps organizations working in sustainability raise funds, thus enhancing their ability to generate economic growth and employment. By streamlining the donation process, ReadForChange helps users save time and focus on productive activities while contributing to a sustainable future.

**Reduced Inequality**  
- ReadForChange reduces inequality by offering a user-friendly and accessible platform that allows anyone, regardless of their financial background, to engage in sustainability efforts. The system’s low-cost design ensures that people from all walks of life can participate in environmental causes. It bridges the gap between those with access to education and resources and those without, enabling everyone to contribute to sustainability projects. Through this, ReadForChange empowers individuals from diverse socio-economic backgrounds to engage in critical environmental conversations and actions.

**Life Below Water**  
- ReadForChange contributes to the SDG "Life Below Water" by promoting awareness and supporting initiatives related to ocean conservation. The system regularly features articles on marine ecosystems, pollution, and biodiversity, encouraging readers to educate themselves about oceanic issues. By facilitating donations to organizations focused on protecting life below water, ReadForChange plays an active role in supporting the preservation of oceans and marine life, thus making a meaningful impact on marine conservation efforts.

**Partnerships for the Goals**  
- ReadForChange fosters partnerships to achieve sustainability goals by connecting users with environmental organizations through its donation system. The platform collaborates with various partners to amplify the impact of its contributions, ensuring that funds are directed to projects addressing environmental challenges. By leveraging these partnerships, ReadForChange strengthens global efforts to achieve the SDGs and encourages collaboration between individuals, organizations, and governments in working towards a sustainable future.
# IV. Instructions for Running the Program
**Step 1:**
- Install Java JDK: Download and install the JDK from here if not already installed.
IDE or Text Editor: Use any editor (VSCode, IntelliJ, Notepad++) to write and compile the Java code.

**Step 2:Creating File**
- Create a File:
- Open your text editor.
- Create a new file named ReadForChange.java.
- Copy and paste the code provided.

**Step 3:Run the code**
- Run the code you’ve copied

**Step 4: User Sign Up / Login**
- Login: If you already have an account, choose the Login option and enter your username and password.
- Sign Up: If you're a new user, choose the Sign Up option and create a new account. You can also choose if you want to sign up as a regular user or an admin.

**Step 5: Explore the Dashboard**
- After logging in, you'll be directed to the Dashboard where you can:
- Browse Articles: Select articles related to environmental causes.
- View Donations: Check the total amount donated and your personal contribution.
- If you're an Admin, you'll also have an option to view all donations made by other users.
- Logout: If you're finished, you can log out.

**Step 6: Read Articles & Donate**
- Select an article you wish to read. Each article is associated with a donation fee.
- After reading the article, they automatically donate the associated fee to the cause discussed in the article.
- The total amount donated will be automatically updated.

**Step 7: View Donation Stats**
- In the Dashboard, you can view:
- Total donations accumulated in the system.
- Your individual donation contributions.

**Step 8: Exit the Program**
- Once you're done, select the Exit option to close the program.
