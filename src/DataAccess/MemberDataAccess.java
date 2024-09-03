package DataAccess;


import Business.Checkout.CheckoutRecord;
import Business.Person.Member;

import java.util.ArrayList;
import java.util.List;

public final class MemberDataAccess extends FileDataAccess{
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
        List<Member> members = (List<Member>)super.read(fileName);
        if (members == null)
            members = new ArrayList<>();
        return members;
    }

    public static void addMember(Member member)
    {
        instance._addMember(member);
    }

    private void _addMember(Member member)
    {
        List<Member> members = readMembers();
        if(members == null) members = new ArrayList<>();
        members.add(member);
        super.write(fileName, members);
    }

    public static Member addCheckoutRecord(CheckoutRecord checkoutRecord)
    {
        return instance._addCheckoutRecord(checkoutRecord);
    }

    private Member _addCheckoutRecord(CheckoutRecord checkoutRecord)
    {
        Member updatedMember = null;
        List<Member> members = readMembers();
        for(Member member : members)
        {
            if(member.getId().equals(checkoutRecord.getMember().getId()))
            {
                member.getCheckoutRecords().add(checkoutRecord);
                updatedMember = member;
                break;
            }
        }
        super.write(fileName, members);
        return updatedMember;

    }
}
