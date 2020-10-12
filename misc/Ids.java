package misc;

public enum Ids {
    Payment("CEDSId"),
    Profile("ProfileId"),
    Loyalty("LoyaltyId");


    private String identifier ;
    Ids(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
