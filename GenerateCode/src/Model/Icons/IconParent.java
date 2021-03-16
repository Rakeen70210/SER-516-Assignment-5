package Model.Icons;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public abstract class IconParent implements java.io.Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	protected int inputLimit;
	protected int outputLimit;
	protected List<IconParent> inputs;
	protected List<IconParent> outputs;
	protected String text;
	protected String value;

	public IconParent(int inputLimit, int outputLimit, String text) {
		this.inputLimit = inputLimit;
		this.outputLimit = outputLimit;
		this.inputs = new ArrayList<>();
		this.outputs = new ArrayList<>();
		this.text = text;
		this.value = "";
	}

	public void addInput(IconParent inputElement) {
		if (this.inputs.size() < inputLimit)
			this.inputs.add(inputElement);
	}

	public void addOutput(IconParent outputElement) {
		if (this.outputs.size() < outputLimit)
			this.outputs.add(outputElement);

	}

    /*
    get input and output methods throw exceptions if trying to access outside of
    input or output bounds.
    */

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isInputSpaceAvailable() {
		return this.inputs.size() < this.inputLimit;
	}

	public boolean isOutputSpaceAvailable() {
		return this.outputs.size() < this.outputLimit;
	}

	public String getText() {
		return this.text;
	}


	public boolean isIconValid(){
        if((inputLimit > 0 && inputs.size() == 0) || (outputLimit > 0 && outputs.size() == 0)){
            return false;
        }
        for(IconParent item : inputs){
            if(item == null){
                return false;
            }
        }
        for(IconParent item: outputs){
            if(item == null){
                return false;
            }
        }
        return true;
    }
}
