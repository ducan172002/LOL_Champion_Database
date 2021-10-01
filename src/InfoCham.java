public class InfoCham {
    private String name, nickname, general_type;
    private int level;
    public InfoCham() {
    }
    public InfoCham(String name, String nickname, String general_type, int level)
    {
        this.name = name;
        this.nickname = nickname;
        this.general_type = general_type;
        this.level = level;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getGeneral_type() {
        return general_type;
    }
    public void setGeneral_type(String general_type) {
        this.general_type = general_type;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Nickname: " + nickname);
        System.out.println("General type: " + general_type);
        System.out.println("Level: " + level);
    }
}
