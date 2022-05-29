package ca.marcinkoziel.countrystats.beans;

public enum PostType {
    AGRICULTURE("Agriculture"),
    COMMUNICATIONS("Communications"),
    CONSTRUCTION("Construction"),
    FINANCE("Finance"),
    MANUFACTURING("Manufacturing"),
    MINING("Mining"),
    RETAIL("Retail"),
    TRANSPORTATION("Transportation"),
    UTILITIES("Utilities");

    private final String name;

    PostType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
