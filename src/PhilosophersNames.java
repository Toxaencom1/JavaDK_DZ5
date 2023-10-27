/**
 * The PhilosophersNames enum represents a list of famous philosophers' names. Each
 * philosopher's name is associated with a unique identifier.
 */
public enum PhilosophersNames {
    PLATO("Plato"),
    ARISTOTLE("Aristotle"),
    SOCRATES("Socrates"),
    CONFUCIUS("Confucius"),
    EPICURUS("Epicurus"),
    KANT("Immanuel Kant"),
    NIETZSCHE("Friedrich Nietzsche"),
    DESCARTES("René Descartes"),
    LOCKE("John Locke"),
    HUME("David Hume"),
    SPINOZA("Baruch Spinoza"),
    WITTGENSTEIN("Ludwig Wittgenstein"),
    HEGEL("Georg Wilhelm Friedrich Hegel"),
    KIERKEGAARD("Søren Kierkegaard"),
    MARX("Karl Marx");

    private final String name;

    /**
     * Creates a new PhilosophersNames enum constant with the specified philosopher's name.
     *
     * @param name The name of the philosopher.
     */
    PhilosophersNames(String name) {
        this.name = name;
    }

    /**
     * Gets the name associated with the philosopher.
     *
     * @return The name of the philosopher.
     */
    public String getName() {
        return name;
    }
}
