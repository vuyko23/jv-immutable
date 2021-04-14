package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can`t copy Engine correctly", e);
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 13 * result + horsePower;
        result = 13 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object engine) {
        if (engine == this) {
            return true;
        }
        if (engine == null) {
            return false;
        }
        if (engine.getClass().equals(Engine.class)) {
            Engine currentEngine = (Engine) engine;
            return horsePower == currentEngine.horsePower
                    && Objects.equals(manufacturer, currentEngine.manufacturer);
        }
        return false;
    }
}
