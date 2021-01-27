/**
 * @Author: lty
 * @Date: 2020/11/24 15:01
 */

/**
 * The facade of the shape interface
 * 提供冗余的门面,使细颗粒度的接口或类可以更易用
 * @return
 * @date   2020/11/24 15:05
 */
public class ShapeFacade {
    private Shape circle;
    private Shape square;
    private Shape rectangle;

    public ShapeFacade() {
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




}
