
package animalplanet;


public class Animal {

    private String name;
    private String scientificName;
    private String region;
    private String imagePath;

    public Animal(String name, String scientificName, String region, String imagePath) {
        this.name = name;
        this.scientificName = scientificName;
        this.region = region;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getRegion() {
        return region;
    }

    public String getImagePath() {
        return imagePath;
    }
}


