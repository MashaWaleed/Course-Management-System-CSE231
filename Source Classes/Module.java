package application;

class Module implements Comparable<Module> {

    public int modulesSpawned = 0;
    private float durationHours;
    private String name;

    Module() {
        modulesSpawned++;
    }

    Module(int hrs, String name) {
        this();
        this.durationHours = hrs;
        this.name = name;
    }

    @Override
    public int compareTo(Module comp) {
        if (this.getDuration() > comp.durationHours) {
            return 1;
        } else if (this.getDuration() == comp.durationHours) {
            return 0;
        } else {
            return 0;
        }
    }

    String getName() {
        return this.name;
    }

    float getDuration() {
        return this.durationHours;
    }
}
