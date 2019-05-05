package list;

public class ActData
{
    String text;
    String desc;
    String time;
    Integer img;

    public ActData(String text, String desc, String time, Integer img)
    {
        this.text = text;
        this.desc = desc;
        this.time = time;
        this.img = img;
    }

    public Integer getImg() { return img; }

    public String getText() { return text; }

    public String getDesc()
    {
        return desc;
    }

    public String getTime()
    {
        return time;
    }
}