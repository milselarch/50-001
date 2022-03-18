//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Date;

class GeometricObject {
    public String color = "white";
    public boolean filled = false;
    public Date dateCreated = new Date();

    public GeometricObject() {
    }

    public GeometricObject(String var1, boolean var2) {
        this.color = var1;
        this.filled = var2;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String var1) {
        this.color = var1;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean var1) {
        this.filled = var1;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public String toString() {
        return "color: " + this.color + "\\nfilled: " + this.filled;
    }
}
