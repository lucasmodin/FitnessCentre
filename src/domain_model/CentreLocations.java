package domain_model;

public enum CentreLocations {
    ADDRESS1("Strandboulevarden"),
    ADDRESS2("Nordre Frihavnsgade"),
    ADDRESS3("J. E. Olsenvej"),
    ADDRESS4("Store Kongensgade"),
    ADDRESS5("Maglevej"),
    ADDRESS6("Randersgade"),
    ADDRESS7("Thorsgade"),
    ADDRESS8("Jagtvej"),
    ADDRESS9("Guldbergsgade"),
    ADDRESS10("Prinsessegade"),
    STOP(null);

    public final String location;

    CentreLocations(String location) {
        this.location = location;
    }
}
