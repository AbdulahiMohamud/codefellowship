## CodeFellowShip
- jBCrypt is a Java implementation of OpenBSD's Blowfish Password hashing code, as described in "http://www.openbsd.org/papers/bcrypt-paper.ps" by Niels Provos and David Mazieres.
- more info: [JBCRYPT - Website](https://www.mindrot.org/projects/jBCrypt/)
****
## Contributors:
****
- code referenced from Alex White  [gitHub](https://github.com/codefellows/seattle-code-java-401d12)
****
## Port Instructions
1. Clone
2. Run ./gradlew run --<args>
3. The app will allow you to create an account and conitnues with website using jBCrypt!
****

****
### Feature Tasks - start a app

The site should have a login page.
The login page should have a link to a signup page.
An ApplicationUser should have a username, password (will be hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.
All of these fields must be set at signup. They will not be editable at any other time.
The site should allow users to create an ApplicationUser on the “sign up” page.
Your Controller should have an @Autowired private PasswordEncoder passwordEncoder; and use that to run passwordEncoder.encode(password) before saving the password into the new user.

Time estimated spent: 2 hours
Actual time spent: 3 hours
****
Time estimated spent: 3 hours
Actual time spent: 5.30 hours

