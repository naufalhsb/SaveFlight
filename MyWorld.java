import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private int score;
    private int birdSpawnCounter;

    public MyWorld()
    {    
        super(600, 400, 1); 
        setPaintOrder(Plane.class, Bird.class);
        Plane plane = new Plane();
        addObject(plane, 100, getHeight() / 2);
        score = 0;
        birdSpawnCounter = 0;
    }

    public void act()
    {
        spawnBirds();
        showText("Score: " + score, 50, 20);
    }

    private void spawnBirds()
    {
        if (birdSpawnCounter == 0) {
            Bird bird = new Bird();
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(bird, getWidth(), y);
        }
        birdSpawnCounter = (birdSpawnCounter + 1) % 100;
    }

    public void increaseScore()
    {
        score++;
    }
}
