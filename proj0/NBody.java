public class NBody{

	public static double readRadius(String str){
		In in = new In(str);
		int planetNumber = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String str){
		In in = new In(str);
		int planetNumber = in.readInt();
		double radius = in.readDouble();
		Body[] body = new Body[planetNumber];
		int index = 0;
		while(index!=5){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			body[index++] = new Body(xxPos, yyPos,xxVel,yyVel,mass,img);
		}
		return body;
	}




	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius =NBody.readRadius(filename);
		Body[] body = NBody.readBodies(filename);
	
		StdDraw.setScale(-radius,radius);
		StdDraw.clear();

		StdDraw.picture(0,0,"image/starfield.jpg");
		for(int i=0;i<body.length;i++){
			body[i].draw();
		}
	}



}
