package blue.sparse.jst.specification.materials.vtf.image;

import org.joml.Vector3f;
import xyz.eutaxy.util.data.RandomAccessReadableData;
import xyz.eutaxy.util.data.RandomAccessWritableData;
import xyz.eutaxy.util.memory.Bits;

import java.awt.image.BufferedImage;

public abstract class ImageFormat {
	//Assuming that the buffer position is exactly where the image format data starts.
	public abstract BufferedImage read(int width, int height, RandomAccessReadableData data);
	public void write(BufferedImage image, RandomAccessWritableData data) {}

	public static Vector3f decodeRGB565(int i) {
		var red = Bits.getBits32(i, 11, 5) / ((float) (1 << 5) - 1);
		var green = Bits.getBits32(i, 5, 6) / ((float) (1 << 6) - 1);
		var blue = Bits.getBits32(i, 0, 5) / ((float) (1 << 5) - 1);
		return new Vector3f(red, green, blue);
	}

	public static short encodeRGB565(Vector3f v) {
		int result = 0;
		result = Bits.withBits32(result, 11, 5, (int) (v.x * ((1 << 5) - 1)));
		result = Bits.withBits32(result, 5, 6, (int) (v.y * ((1 << 6) - 1)));
		result = Bits.withBits32(result, 0, 5, (int) (v.z * ((1 << 5) - 1)));
		return (short) result;
	}

	public static Vector3f decodeRGB888(int i) {
		var red = Bits.getBits32(i, 16, 8) / ((float) (1 << 8) - 1);
		var green = Bits.getBits32(i, 8, 8) / ((float) (1 << 8) - 1);
		var blue = Bits.getBits32(i, 0, 8) / ((float) (1 << 8) - 1);
		return new Vector3f(red, green, blue);
	}

	public static int encodeRGB888(Vector3f v) {
		int result = 0;
		result = Bits.withBits32(result, 16, 8, (int) (v.x * ((1 << 8) - 1)));
		result = Bits.withBits32(result, 8, 8, (int) (v.y * ((1 << 8) - 1)));
		result = Bits.withBits32(result, 0, 8, (int) (v.z * ((1 << 8) - 1)));
		return result;
	}
}