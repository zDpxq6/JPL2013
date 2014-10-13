package mask;

public class X {
	{
		System.out.println("X, 初期化子前:\t" + this.xMask);
	}
	protected int xMask = 0x00ff;
	{
		System.out.println("X, 初期化子後:\t" + this.xMask);
	}
	protected int fullMask ;

	public X(){
		this.fullMask = this.xMask;
		System.out.println("X, Const.後:\t"+this.xMask);
	}

	public int mask(int orig){
		return orig & this.fullMask;
	}

//	public X(){
//		printMasks("�X�[�p�[�N���X�Œ�`����Ă���t�B�[���h(�Ȃ�)���X�[�p�[�N���X�̃R���X�g���N�^�ɂ���ď�����A\n"
//				+ "X�N���X�Œ�`����Ă���t�B�[���h��X�N���X�̏���q�ɂ���ď����ꂽ���");
//		this.fullMask = this.xMask ;
//		printMasks("X�N���X�̃R���X�g���N�^�ɂ�鏉��������ꂽ���");
//	}
//
//	public int mask(int orig){
//		return orig & this.fullMask;
//	}

	void printMasks(String message){
		System.out.printf (	message + "%n"
						+	"xMask:\t\t%04x%n"
						+	"yMaks:\t\t-%n"
						+	"fullMask:\t%04x%n%n",this.xMask,this.fullMask);
	}
}