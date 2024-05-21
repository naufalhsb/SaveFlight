import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Plane extends Actor
{
    public Plane()
    {
        GreenfootImage image = getImage();
        image.scale(100, 100); // Sesuaikan ukuran 50x50 sesuai keinginan Anda
        setImage(image);
    }

    public void act()
    {
        checkKeyPress();
        checkCollision();
    }

    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
        }
    }

    private void checkCollision()
    {
        if (isTouching(Bird.class)) {
            Greenfoot.stop();
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }
}
