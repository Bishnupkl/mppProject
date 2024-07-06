package Business.Person;

import java.util.List;

public final class PersonFactory {
    private PersonFactory(){}

    public static Member generateMember(String memberId, String firstName, String lastName, String street, String city, String state, String zip, String telephone)
    {
        Address address = new Address(street, city, state, zip);
        Member member = new Member(memberId, firstName, lastName, telephone, address);
        return member;
    }

    public static User generateUser(String id, String password, List<UserRole> userRoles)
    {
        return new User(id, password, userRoles);
    }

    public static Author generateAuthor(String firstName,String lastName, String phoneNumber,  String credentials, String bio, String street, String city, String state, String zip)
    {
        Address address = new Address(street, city, state, zip);
        return new Author(firstName, lastName, phoneNumber,address,credentials,bio);
    }

}
