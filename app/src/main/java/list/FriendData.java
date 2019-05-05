package list;

public class FriendData
{
    String text;
    String desc;
    String time;

    public FriendData(String text, String desc, String time)
    {
        this.text = text;
        this.desc = desc;
        this.time = time;
    }

    public String getText()
    {
        return text;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getTime()
    {
        return time;
    }
}