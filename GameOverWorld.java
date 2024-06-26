import greenfoot.*;

public class GameOverWorld extends World
{
    public GameOverWorld(int score)
    {
        super(600, 400, 1);
        showText("Game Over", getWidth() / 2, getHeight() / 2 - 50);
        showText("Your Score: " + score, getWidth() / 2, getHeight() / 2);
        Button backButton = new Button("Back to Menu");
        addObject(backButton, getWidth() / 2, getHeight() / 2 + 50);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(null)) {
            Actor clickedActor = Greenfoot.getMouseInfo().getActor();
            if (clickedActor instanceof Button) {
                Button button = (Button) clickedActor;
                if (button.getText().equals("Back to Menu")) {
                    Greenfoot.setWorld(new MenuWorld());
                }
            }
        }
    }
}
