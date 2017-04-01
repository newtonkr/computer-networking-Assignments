class Input{
    public static String read_string(){
        String read="";
        try{
            read = new BufferedReader(new InputStreamReader(System.in), 1).readLine();
        }catch (IOException ex){
            System.out.println("error reading from the input stream!");
        }
        return read;
    }
}