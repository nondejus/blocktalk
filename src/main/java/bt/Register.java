package bt;

import java.lang.reflect.Method;

/**
 * A convenient 256 bit register (4 longs).
 * 
 * Used, for instance, when getting the hash of a block. This is also the current
 * size limit of messages received or sent by a contract.
 * 
 * @author jjos
 */
public class Register {
	long value[] = new long[4];

	Method method;
	Object[] args;

	@EmulatorWarning
	public static Register newMethodCall(Method m, Object[] args) {
		Register r = new Register();
		r.method = m;
		r.args = args;
		return r;
	}

	@EmulatorWarning
	public static Register newInstance(long value1, long value2, long value3, long value4) {
		Register r = new Register();
		r.value[0] = value1;
		r.value[1] = value2;
		r.value[2] = value3;
		r.value[3] = value4;

		return r;
	}

	/**
	 * @return the first long value
	 */
	public long getValue1() {
		return value[0];
	}
	/**
	 * @return the second long value
	 */
	public long getValue2() {
		return value[1];
	}
	/**
	 * @return the third long value
	 */
	public long getValue3() {
		return value[2];
	}
	/**
	 * @return the fourth long value
	 */
	public long getValue4() {
		return value[3];
	}

	public boolean equals(Register other) {
		for (int i = 0; i < value.length; i++) {
			if(value[i] != other.value[i])
				return false;
		}
		return true;
	}

	@EmulatorWarning
	public Method getMethod() {
		return method;
	}
	@EmulatorWarning
	public Object[] getMethodArgs() {
		return args;
	}

	@Override
	@EmulatorWarning
	public String toString() {
		if(method!=null){
			String ret = method.getName() + '(';
			for (int i = 0; i < args.length && args[i]!=null; i++) {
				if(i>0)
					ret += ", ";
				ret += args[i].toString();
			}
			ret += ')';
			return ret;
		}
		return super.toString();
	}
}
