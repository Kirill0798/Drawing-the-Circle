package sample;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Circle {

    double coordX;
    double coordY;
    double radius;

    public Circle(){
        this.coordX = 0;
        this.coordY = 0;
        this.radius = 100;
    }
    public Circle(double coordX, double coordY, double radius){
        this.coordX = coordX;
        this.coordY = coordY;
        this.radius = radius;
    }
    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public double getRadius() {
        return radius;
    }

    @XmlElement
    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }
    @XmlElement
    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
    @XmlElement
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void movingVector(double x, double y){
        this.coordX += x;
        this.coordY += y;
    }
    public void increaseRadius(Double r){
        this.radius *= r;
    }
}
