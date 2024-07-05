package DataAccess;


import Business.Checkout.CheckoutRecord;
import Business.Person.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDataAccess extends FileDataAccess{
    private static final String fileName = "member.bin";
    private static final MemberDataAccess instance = new MemberDataAccess();

    private MemberDataAccess(){};


    public static Member readMember(String id)
    {
        List<Member> members = instance.readMembers();
        if(members == null) return null;

        for (Member member:  members) {
            if (member.getId().equals(id)) return member;
        }
        return null;
    }

    public List<Member> readMembers()
    {
        return (List<Member>)super.read(fileName);
    }

    public static void addMember(Member person)
    {
        instance._addMember(person);
    }

    private void _addMember(Member member)
    {
        List<Member> members = readMembers();
        if(members == null) members = new ArrayList<>();
        members.add(member);
        super.write(fileName, members);
    }

    public static void addCheckoutRecord(CheckoutRecord checkoutRecord)
    {
        instance._addCheckoutRecord(checkoutRecord);
    }

    private void _addCheckoutRecord(CheckoutRecord checkoutRecord)
    {
        List<Member> members = readMembers();
        for(Member member : members)
        {
            if(member.getId().equals(checkoutRecord.getMember().getId()))
            {
                member.getCheckoutRecords().add(checkoutRecord);
            }
        }
        super.write(fileName, members);
    }
}
