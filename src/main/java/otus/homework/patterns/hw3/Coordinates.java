package otus.homework.patterns.hw3;

import lombok.Data;

@Data
public class Coordinates {
int x;
int y;

    public Coordinates(int x,int y){
    this.x=x;
    this.y=y;

}
    public static Coordinates plus(Coordinates position, Coordinates velocity){
        return new Coordinates(
                position.getX() + velocity.getX(),
                position.getY() + velocity.getY()
        );
    }
}
