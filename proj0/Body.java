public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;

	public Body(double xxPos, double yyPos,double xxVel,double yyVel,double mass,String imgFileName){
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		double distance = 0;
		distance = Math.sqrt(Math.pow(this.xxPos-b.xxPos, 2)+Math.pow(this.yyPos-b.yyPos,2));
		return distance;
	}
	
	public double calcForceExertedBy(Body b){
		double force = 0;
		double distance = this.calcDistance(b);
		force = G*b.mass*this.mass / Math.pow(distance,2);
		return force;
	}
	
	public double calcForceExertedByX(Body b){
		double forcex = 0;
		double force = this.calcForceExertedBy(b);
		double distancex = b.xxPos-this.xxPos;
		double distance = this.calcDistance(b);
		forcex = force * distancex / distance;
		return forcex;
	}

	
	public double calcForceExertedByY(Body b){
		double forcey = 0;
		double force = this.calcForceExertedBy(b);
		double distancey = b.yyPos-this.yyPos;
		double distance = this.calcDistance(b);
		forcey = force * distancey / distance;
		return forcey;
	}

	public double calcNetForceExertedByX(Body[] allbody){
		double forcex = 0;
		for(int i=0;i<allbody.length;i++){
			if(!allbody[i].equals(this)){
				forcex += this.calcForceExertedByX(allbody[i]);
			}
		}
		return forcex;
	}


	public double calcNetForceExertedByY(Body[] allbody){
		double forcey = 0;
		for(int i=0;i<allbody.length;i++){
			if(!allbody[i].equals(this)){
				forcey += this.calcForceExertedByY(allbody[i]);
			}
		}
		return forcey;
	}

	public void update(double t, double forcex,double forcey){
		double ax = forcex/this.mass;
		double ay = forcey/this.mass;
		this.xxVel += t*ax;
		this.yyVel += t*ay;
		this.xxPos += t*this.xxVel;
		this.yyPos += t*this.yyVel;
	}	

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos,"images/"+this.imgFileName); 
	}





}

