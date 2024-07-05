package DataAccess;


import Business.Person.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDataAccess extends FileDataAccess{
    private static final String fileName = "member.bin";
    private static final MemberDataAccess instance = new MemberDataAccess();

    private MemberDataAccess(){};


    public static Member readMember(String id)
    {
        for (Member p:  instance.readMembers()) {
            if (p.getId().equals(id)) return p;
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
        if (members == null) {
            members = new ArrayList<>();
        }
        members.add(member);
        super.write(fileName, members);
    }
}
