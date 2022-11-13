package io.example.patterns.mediator.cases;

/**
 * @author luxz
 * @date 2022/11/13-16:15
 */
public class UnitedNationsSecurityCouncil extends UnitedNations {
    private USA usa;
    private Iraq iraq;

    public void setUsa(USA usa) {
        this.usa = usa;
    }

    public void setIraq(Iraq iraq) {
        this.iraq = iraq;
    }

    @Override
    public void Declare(String message, Country colleague) {
        if (colleague instanceof USA) {
            iraq.receive(message);
        }
        if (colleague instanceof Iraq) {
            usa.receiveMessage(message);
        }
    }
}
