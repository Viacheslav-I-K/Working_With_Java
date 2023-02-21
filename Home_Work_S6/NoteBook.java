public class NoteBook {
    String name;
    Integer ram;
    Integer hdd;
    String os;
    Integer weight;
    Integer price;

    NoteBook(String name, Integer ram, Integer hdd, String os, Integer weight, Integer price) {
        this.name = name;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.weight = weight;
        this.price = price;
    }

    void PrintAll() {
        System.out.println("| " + name + "\t" + "| " + ram + "\t| " + hdd + "\t| " + os + " |  " + weight + "   | " + price + " |");
    }

    void PrintRAM() {
        System.out.println("| " + name + "\t" + "| " + ram + "\t |");
    }

    void PrintHDD() {
        System.out.println("| " + name + "\t" + "| " + hdd + "\t |");
    }

    void PrintOS() {
        System.out.println("| " + name + "\t" + "| " + os + " |");
    }

    void PrintWeight() {
        System.out.println("| " + name + "\t" + "| " + weight + "\t |");
    }

    void PrintPrice() {
        System.out.println("| " + name + "\t" + "| " + price + "\t |");
    }
}
