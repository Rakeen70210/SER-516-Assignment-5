package Model.Icons;

import java.io.Serial;
import java.util.ArrayList;

public class AtSymbol extends IconParent {
    @Serial
    private static final long serialVersionUID = 1L;

    public AtSymbol() {
        super(2, 2, Constants.AT);
    }

    @Override
    public boolean isIconValid(){
        boolean isLoopConditionFilled = false;
        ArrayList<IconParent> visitedIcons = new ArrayList<IconParent>();
        visitedIcons.add(this);
        int count = 0;
        while(count < visitedIcons.size()){
            for(IconParent output : visitedIcons.get(count).outputs){
                if(output == this){
                    isLoopConditionFilled = true;
                    break;
                }
                else{
                    if(!visitedIcons.contains(output)){
                        visitedIcons.add(output);
                    }
                }
            }
            count++;
        }
        boolean valid = connectionsFilled();
        return(valid && isLoopConditionFilled);
    }
}
