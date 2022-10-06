package com.goodee.main;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class JB04_Buffer {
	public static void main(String[] args) {
		ByteBuffer buffer1 = ByteBuffer.allocate(100); // 힙선언
		ByteBuffer buffer2 = ByteBuffer.allocateDirect(100); // 다이렉트 선언
		
		System.out.println(" 저장용량 : " + buffer1.capacity() + "바이트");
		System.out.println(" 저장용량 : " + buffer2.capacity() + "바이트");
		
		byte[] byte1 = new byte[100];
		byte[] byte2 = new byte[7];
		
		ByteBuffer buffer3 = ByteBuffer.wrap(byte1);
		ByteBuffer buffer4 = ByteBuffer.wrap(byte2);  // wrap으로 선언되면 다이랙트로 저장되는 걸로 얼고 있음 (강사님)

		System.out.println(" 저장용량 : " + buffer3.capacity() + "바이트");
		System.out.println(" 저장용량 : " + buffer4.capacity() + "바이트");
		
		System.out.println("-------------------데이터 제어----------------------");
		
		printState(buffer4);
		
		buffer4.put((byte)10);
		buffer4.put((byte)11);
		System.out.println("[2바이트 저장 후]");
		printState(buffer4);

		buffer4.put((byte)12);
		buffer4.put((byte)13);
		buffer4.put((byte)14);
		System.out.println("[3바이트 저장 후]");
		printState(buffer4);
		
		buffer4.flip(); // position하고 limit의 위치가 바뀐다.
		// position은 위치 0으로 limit은 채워진 대이터의 끝에 위치함.
		System.out.println("[flip 실행 후]");
		printState(buffer4);
		
		byte[] byte3 = new byte[3];
		buffer4.get(byte3);
		System.out.println(byte3[0]+","+byte3[1]+","+byte3[2]);
		System.out.println("[3바이트 읽은 후]");
		printState(buffer4);
		
		buffer4.mark();
		System.out.println("-----------------------------[현재 위치를 마크 해놓음]");
		
		byte[] byte4 = new byte[2];
		buffer4.get(byte4);
		System.out.println(byte4[0] + "," + byte4[1]);
		System.out.println("[2바이트 읽은 후]");
		printState(buffer4);
		
		buffer4.reset();
		System.out.println("-----------------------------[position을 mark 위치로 옮김]");
		printState(buffer4);
		
		buffer4.rewind(); // position만 원상복구
		System.out.println("[rewind 실행 후]");
		printState(buffer4); 
		
		buffer4.clear(); // limit=capacity ,  position 원상복구 
		System.out.println("[clear() 실행 후]");
		printState(buffer4);  
		
	}
	
	public static void printState(Buffer buffer) {
		System.out.print("\tposition : " + buffer.position()); // 실제 포지션 바로 앞에 있는 박으로 넣어주고 한칸식 밀리는 것을 볼 수 있다.
		System.out.print("\tlimit : " + buffer.limit());
		System.out.println("\tcapacity : " + buffer.capacity());
	}
}
