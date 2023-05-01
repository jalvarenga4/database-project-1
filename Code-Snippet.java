import java.util.*;

import jakarta.persistence.*;
import model.*;
import model.Package;

public class App {
    // These demos show finding, creating, and updating individual objects.
    private static void InstantiateModels() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("museumDb");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();


        ArrayList<Object> list = new ArrayList<Object>();
        int i = 0;
        Features a = new Features("leather seats");
        //list.add(a);

        Features b = new Features("plug-in hybrid");
        list.add(b);
        Features c = new Features("power sliding doors");
        list.add(c);
        Features d = new Features("hands-free sliding doors");
        list.add(d);
        Features e = new Features("Amazon FireTV");
        list.add(e);
        Features f = new Features("rear-seat entertainment screens");
        list.add(f);
        Features g = new Features("all-wheel drive");
        list.add(g);
        Features h = new Features("adaptive cruise control");
        list.add(h);

        em.persist(a);
        em.persist(b);
        em.persist(c);
        em.persist(d);
        em.persist(e);
        em.persist(f);
        em.persist(g);
        em.persist(h);

        Package j = new Package("Theatre Package");
        Set<Features> featureset = new HashSet<>();
        Set<Trims> trimset = new HashSet<>();
        Set<AvailablePackages> availablelist = new HashSet<>();
        Set<Package> packagelist = new HashSet<>();
        featureset.add(f);
        j.setPackageFeatures(featureset);
        list.add(j);
        featureset.clear();
        Package k = new Package("Amazon Theatre Package");
        featureset.add(f);
        featureset.add(e);
        k.setPackageFeatures(featureset);
        list.add(k);
        featureset.clear();
        Package l = new Package("Safety Package");
        featureset.add(h);
        l.setPackageFeatures(featureset);
        list.add(l);
        featureset.clear();

        em.persist(j);
        em.persist(k);
        em.persist(l);


        Models pacifica = new Models("Pacifica", 2022);
        featureset.add(c);
        pacifica.setFeatures(featureset);
        //Trims
        Trims touring = new Trims("touring", 30000);
        AvailablePackages temp = new AvailablePackages(); // saftey package
        list.add(temp);
        //packagelist.add(l); // add saftey package to list
        temp.setPackages(l);// add saftey package to available packages of trim
        temp.setCost(3000);// set cost of available package
        availablelist.add(temp);// ad to set of available to add to trim
        touring.setAvailablepackages(availablelist);
        trimset.add(touring);// add trim to trimset to add to model at the end
        list.add(touring);


        em.persist(touring);

        em.persist(temp);


        Trims limited = new Trims("Limited", 34000);
        featureset.clear();
        availablelist.clear();
        featureset.add(d);
        featureset.add(a); //leather seats
        limited.setFeatures(featureset); // add features
        AvailablePackages amazonpackage = new AvailablePackages(); // compatible package
        amazonpackage.setPackages(k);
        amazonpackage.setCost(2500);
        availablelist.add(amazonpackage);
        limited.setAvailablepackages(availablelist);
        trimset.add(limited); // add to trim list to add to model later
        list.add(limited);
        list.add(amazonpackage);
        Trims pinnacle = new Trims("Pinnacle", 42000);
        featureset.clear();
        availablelist.clear();
        featureset.add(a);//leather seats
        featureset.add(d);
        featureset.add(f);
        featureset.add(e);
        featureset.add(g);
        pinnacle.setFeatures(featureset);
        trimset.add(pinnacle);
        pacifica.setTrims(trimset);
        trimset.clear();
        list.add(pinnacle);
        list.add(pacifica);
        em.persist(pacifica);
        em.persist(pinnacle);
        em.persist(amazonpackage);
        em.persist(limited);


        Models pacificahybrid2022 = new Models("Pacifica Hybrid", 2022);
        featureset.clear();
        featureset.add(c);
        featureset.add(b);
        pacificahybrid2022.setFeatures(featureset);
        featureset.clear();
        //Trims
        Trims touring2 = new Trims("Touring", 43000);
        trimset.add(touring2);
        Trims limited2 = new Trims("Limited", 48000);
        featureset.add(a);
        featureset.add(d);
        limited2.setFeatures(featureset);
        featureset.clear();
        availablelist.add(amazonpackage);
        limited2.setAvailablepackages(availablelist);
        availablelist.clear();
        trimset.add(limited2);


        em.persist(touring2);
        em.persist(limited2);


        Trims pinnacle2 = new Trims("Pinnacle", 54000);
        featureset.add(a);
        featureset.add(d);
        featureset.add(f);
        featureset.add(h);
        pinnacle2.setFeatures(featureset);
        featureset.clear();
        trimset.add(pinnacle2);
        pacificahybrid2022.setTrims(trimset);
        trimset.clear();
        Models pacificahybrid2021 = new Models("Pacifica Hybrid", 2021);
        featureset.add(b);
        featureset.add(c);
        pacificahybrid2021.setFeatures(featureset);
        featureset.clear();
        //Trims
        Trims touring3 = new Trims("Touring", 41000);
        availablelist.add(temp);
        touring3.setAvailablepackages(availablelist);
        availablelist.clear();
        trimset.add(touring3);

        em.persist(pinnacle2);
        em.persist(pacificahybrid2021);
        em.persist(touring3);


        Trims limited3 = new Trims("Limited", 46000);
        featureset.add(a);
        featureset.add(d);
        limited3.setFeatures(featureset);
        featureset.clear();
        availablelist.add(temp);
        AvailablePackages theatrepackage = new AvailablePackages();
        theatrepackage.setPackages(j);
        theatrepackage.setCost(2500);
        availablelist.add(theatrepackage);
        limited3.setAvailablepackages(availablelist);
        availablelist.clear();
        trimset.add(limited3);
        Trims pinnacle3 = new Trims("Pinnacle", 52000);
        featureset.add(a);
        featureset.add(d);
        featureset.add(f);
        featureset.add(h);
        pinnacle3.setFeatures(featureset);
        featureset.clear();
        trimset.add(pinnacle3);

        em.persist(limited3);
        em.persist(theatrepackage);
        em.persist(pinnacle3);


        pacificahybrid2021.setTrims(trimset);
        em.persist(pacificahybrid2022);
        trimset.clear();


        Automobiles auto1 = new Automobiles("12345abcde");
        auto1.setTrims(limited);
        availablelist.add(amazonpackage);
        auto1.setAvailablePackages(availablelist);
        availablelist.clear();

        list.add(auto1);

        Automobiles auto2 = new Automobiles("67890abcde");
        auto2.setTrims(pinnacle2);
        list.add(auto2);

        Automobiles auto3 = new Automobiles("99999aaaaa");
        auto3.setTrims(pinnacle3);
        list.add(auto3);

        Automobiles auto4 = new Automobiles("aaaaa88888");
        auto4.setTrims(touring3);
        availablelist.add(temp);
        auto4.setAvailablePackages(availablelist);
        list.add(auto4);

        Automobiles auto5 = new Automobiles("bbbbb77777");
        auto4.setTrims(limited3);
        availablelist.add(theatrepackage);
        auto5.setAvailablePackages(availablelist);
        list.add(auto5);
        list.add(theatrepackage);


        em.persist(auto1);
        em.persist(auto2);
        em.persist(auto3);
        em.persist(auto4);
        em.persist(auto5);
        em.getTransaction().commit();
        //em.getTransaction().begin();
        // em.persist(auto1);
        //em.getTransaction().commit();

      /*  for(int x=0;x<list.size()+1;x++){
         em.getTransaction().begin();
         em.persist(list.get(x));
            em.getTransaction().commit();
        }*/


    }





    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x;
        InstantiateModels();
        while (true) {
            System.out.println("Enter 1 for an Automobile lookup.");
            System.out.println("Enter 2 to search for a particular feature.");
            System.out.println("Enter anything else to exit. ");

            x = sc.nextInt();
            if (x == 1) {
                System.out.println("Enter vin");
                String vin = sc.next();
                autoLockup(vin);
            }

            if(x==2){
                System.out.println("Enter name of feature.");
                String f = sc.next();
                featureLookup(f);
            }

            else break;



        }

    }

    private static void featureLookup(String f) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("museumDb");
        EntityManager em = factory.createEntityManager();

        var name = em.createQuery("Select m From Automobiles Join m.AvailablePackages" +
                "Join t.features = ?1",Automobiles.class);
        name.setParameter(1,f);
        try{
            Automobiles auto = name.getSingleResult();
            //System.out.println("["+auto.getTrims().getModels().getYear()+"] " +
            System.out.println(auto.getAuto_id()+" "+ auto.getVin());

            //System.out.println("["+auto.stickerPrice()+"]");



        }
        catch(NoResultException ex){
            System.out.println("No Results");
        }


        }



    private static void autoLockup(String f) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("museumDb");
        EntityManager em = factory.createEntityManager();

        var vin = em.createQuery("Select v From Automobiles v where v.vin = ?1",Automobiles.class);
        vin.setParameter(1,f);

        try{
           Automobiles auto = vin.getSingleResult();
            //System.out.println("["+auto.getTrims().getModels().getYear()+"] " +
            System.out.println(auto.getAuto_id()+" "+ auto.getVin());

            //System.out.println("["+auto.stickerPrice()+"]");



        }
        catch(NoResultException ex){
            System.out.println("No Results");
        }
    }

}
