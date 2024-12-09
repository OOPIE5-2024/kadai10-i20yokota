package ex10;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

//@SuppressWarnings("serial")
public class GrayImage extends BufferedImage{
	
	public GrayImage(BufferedImage img) {
		// 親クラスのコンストラクタ(グレイスケールで作成)
		super(img.getWidth(),img.getHeight(),TYPE_BYTE_GRAY);
		// Graphicsオブジェクトを作成し
		Graphics g = createGraphics();
		// 画像を自身に書き込む
		g.drawImage(img, 0, 0, null);
		
	}
	
	
  // 現在は機能なし
  public int getGray(int x,int gray) { 
	  return 0;
  }
  
  // 現在は機能なし
  public void setGray(int x, int y, int gray) {
	  return;
  }
}
