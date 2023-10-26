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

    PhilosophersNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
