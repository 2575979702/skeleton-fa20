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
		while(index!=planetNumber){
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

		StdDraw.picture(0,0,"images/starfield.jpg");
		for(int i=0;i<body.length;i++){
			body[i].draw();
		}
		
		StdDraw.enableDoubleBuffering();
		int time = 0;
		for(time = 0; time <= T; time++){
			double[] xForces = new double[body.length];
			double[] yForces = new double[body.length];
			for(int i=0;i<body.length;i++){
				xForces[i] = body[i].calcNetForceExertedByX(body);
				yForces[i] = body[i].calcNetForceExertedByY(body);
			}
			for(int i=0;i<body.length;i++){
				body[i].update(time, xForces[i], yForces[i]);
			}
			//Draw background
			StdDraw.setScale(-radius,radius);
			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(Body b:body){
				b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			
		}
		StdOut.printf("%d\n",body.length);
                StdOut.printf("%.2e\n", radius);
                for(int i=0;i<body.length;i++){
                        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                                        body[i].xxPos, body[i].yyPos, body[i].xxVel,
                                        body[i].yyVel, body[i].mass, body[i].imgFileName);
                }

	}

	






}
