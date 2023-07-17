public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Bos" : "Dolu"));


        System.out.println("Dizideki Eleman Sayisi : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(10); liste.add(20); liste.add(30); liste.add(40);
        System.out.println("Dizideki Eleman Sayisi : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        liste.add(50); liste.add(60); liste.add(70); liste.add(80); liste.add(90); liste.add(100);
        liste.add(110);
        liste.add(50); liste.add(60); liste.add(70); liste.add(80); liste.add(90); liste.add(100);
        liste.add(110);
        liste.add(90); liste.add(100);
        liste.add(90); liste.add(100);

        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Bos" : "Dolu"));

        System.out.println("Dizideki Eleman Sayisi : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        System.out.println(liste.toString());
        liste.remove(3);
        System.out.println("Dizideki Eleman Sayisi : " + liste.size());
        System.out.println(liste.toString());

        MyList<Integer> altListem = liste.subList(0,3);

        System.out.println("Dizideki Eleman Sayisi : " + altListem.size());
        System.out.println("Dizinin Kapasitesi : " + altListem.getCapacity());

        System.out.println(altListem.toString());
        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Listemde 20 degeri : " + liste.contains(20));
        System.out.println("Listemde 120 degeri : " + liste.contains(120));


        altListem.clear();
        System.out.println(altListem.toString());




    }
}