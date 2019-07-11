package org.jason;

public class Park {

    private int xlength;

    private int ylength;


    public Park(int xlength, int ylength) throws Exception{
        if(xlength<1 || ylength<1){
            throw new Exception("the park's xlength and ylength must be than 1");
        }
        this.xlength = xlength;
        this.ylength = ylength;
    }

    @Override
    public String toString() {
        return "Park{" +
                "xlength=" + xlength +
                ", ylength=" + ylength +
                '}';
    }

    public int getXlength() {
        return xlength;
    }



    public int getYlength() {
        return ylength;
    }


}
