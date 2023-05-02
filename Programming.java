public interface Programming {

    // languages the students wish to learn
    int languagesToLearn = 4;

    // Greeting in all languages
    String greetings[] = {"System.out.println('Hello World');",
            "cout << 'Hello World' << endl;",
            "printf('Hello World');",
            "print('Hello World')"};

    // function to be implemented to greet in the languages known
    void greet();
}