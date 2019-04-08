package ie.tudublin;

import processing.core.PApplet;

public class Display extends UIElements
{
    private float size;
    private String analysis;
    private boolean visited;
    private int Increasethreat;
    
    public Display(float x, float y, PApplet ui, float size, String analysis, int Increasethreat)
    {
        super(x,y,ui);
        this.size = size;
        this.analysis = analysis;
        this.Increasethreat = Increasethreat;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.rect(x,y,size,size);
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the analysis
     */
    public String getAnalysis() {
        return analysis;
    }

    /**
     * @param analysis the analysis to set
     */
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    /**
     * @return the visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return the increasethreat
     */
    public int getIncreasethreat() {
        return Increasethreat;
    }

    /**
     * @param increasethreat the increasethreat to set
     */
    public void setIncreasethreat(int increasethreat) {
        Increasethreat = increasethreat;
    }

}