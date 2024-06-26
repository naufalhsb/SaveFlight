import greenfoot.*;

public class MyWorld extends World
{
    private int score;
    private int birdSpawnCounter;
    private int initialPlaneX;
    private Plane plane;
    private int planeHealth;

    public MyWorld()
    {
        super(600, 400, 1);
        setPaintOrder(Plane.class, Bird.class, StrongerBird.class, Bullet.class);
        plane = new Plane();
        addObject(plane, 100, getHeight() / 2);
        initialPlaneX = 100;
        score = 0;
        birdSpawnCounter = 0;
        planeHealth = 3;
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("p")) {
            Greenfoot.setWorld(new PauseWorld(this));
        }

        spawnBirds();
        showText("Score: " + score, 50, 20);
        showText("Health: " + planeHealth, 50, 40);

        if (planeHealth <= 0) {
            Greenfoot.setWorld(new GameOverWorld(score));
        }
    }

    private void spawnBirds()
    {
        if (birdSpawnCounter == 0) {
            Actor bird;
            if (Greenfoot.getRandomNumber(100) < 10) {
                bird = new StrongerBird();
            } else {
                bird = new Bird();
            }
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(bird, getWidth(), y);
        }
        birdSpawnCounter = (birdSpawnCounter + 1) % 100;
    }

    public void increaseScore()
    {
        score++;
    }

    public void decreaseHealth()
    {
        planeHealth--;
    }

    public void addShield()
    {
        plane.addShield();
    }

    public int getInitialPlaneX()
    {
        return initialPlaneX;
    }
}
