package b5;

import b3.Command;
import b4.Observer;

class ACSetTemperatureCommand implements Command, Observer {
    private final AirConditioner ac;
    private int prevTemp;
    private final int newTemp;

    @Override
    public void update(int temperature) {
        System.out.println("Điều hòa: Nhiệt độ " + ac.getTemp() + "°C");
    }

    public ACSetTemperatureCommand(AirConditioner ac, int newTemp) {
        this.ac = ac;
        this.newTemp = newTemp;
    }

    @Override
    public void execute() {
        prevTemp = ac.getTemp();
        ac.setTemp(newTemp);
    }

    @Override
    public void undo() {
        ac.setTemp(prevTemp);
    }

}


