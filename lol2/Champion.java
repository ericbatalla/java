package lol2;

public class Champion {
    private int id;
    private String name;
    private String title;
    private String tags;
    private String lore;

    public Champion(int id, String name, String title, String tags, String lore) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.tags = tags;
        this.lore = lore;
    }

    public Champion(String name, String title, String tags, String lore) {
        this.name = name;
        this.title = title;
        this.tags = tags;
        this.lore = lore;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getTitle() { return title; }
    public String getTags() { return tags; }
    public String getLore() { return lore; }
}
