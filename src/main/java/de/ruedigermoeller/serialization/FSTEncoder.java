package de.ruedigermoeller.serialization;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ruedi on 27.03.14.
 */
public interface FSTEncoder {

    // BLOB methods (from externalizable) ..
    void writeFByteArr(byte[] array) throws IOException;
    void writeFByteArr(byte[] array, int start, int length) throws IOException;
    void writeFCharArr(char[] chars) throws IOException;
    // .. BLOB methods (from externalizable)

    public void writePrimitiveArray(Object array) throws IOException;
    void writeStringUTF(String str) throws IOException;

    void writeFShort(short c) throws IOException;
    void writeFChar(char c) throws IOException;
    void writeFByte(int v) throws IOException;
    void writeFInt(int anInt) throws IOException;
    void writeFLong(long anInt) throws IOException;
    void writeFFloat(float value) throws IOException;
    void writeFDouble(double value) throws IOException;

    int getWritten();
    void setWritten(int written);
    void skip(int i);

    /**
     * close and flush to underlying stream if present. The stream is also closed
     * @throws java.io.IOException
     */
    void close() throws IOException;
    void reset();
    void reset(byte[] out);

    /**
     * resets stream (positions are lost)
     * @throws java.io.IOException
     */
    void flush() throws IOException;

    /**
     * used to write uncompressed int (guaranteed length = 4) at a (eventually recent) position
     * @param position
     * @param v
     */
    void writeInt32At(int position, int v);

    /**
     * if output stream is null, just encode into a byte array
     * @param outstream
     */
    void setOutstream(OutputStream outstream);

    void ensureFree(int bytes) throws IOException;

    byte[] getBuffer();

    void registerClass(Class possible);

    void writeClass(FSTObjectOutput out, Class cl);
    void writeClass(FSTObjectOutput out,FSTClazzInfo clInf);
    
}
