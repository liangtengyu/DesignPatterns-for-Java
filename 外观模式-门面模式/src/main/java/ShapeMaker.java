/**
 * @Author: lty
 * @Date: 2020/11/24 15:01
 */

/**
 * 外观类
 * @return
 * @date   2020/11/24 15:05
 */
public class ShapeMaker {
    private Shape circle;
    private Shape square;
    private Shape rectangle;

    public ShapeMaker() {
        circle = new Circle();
        square = new Square();
        rectangle = new Rectangle();
    }

    public void drawcircle() {
        circle.draw();
    }
    public void drawsquare() {
        square.draw();
    }
    public void drawrectangle() {
        rectangle.draw();
    }

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawrectangle();
    }
}
