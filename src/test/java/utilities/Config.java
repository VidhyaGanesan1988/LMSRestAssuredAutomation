package utilities;

public class Config {
	
	public static final String BASE_URL = "https://lms-backend-service.herokuapp.com/lms";
	public static final String GetAllProgram_URL = "https://lms-backend-service.herokuapp.com/lms/allPrograms";
	public static final String GetSingleProgram_URL = "https://lms-backend-service.herokuapp.com/lms/programs";
	public static final String PostProgram_URL = "https://lms-backend-service.herokuapp.com/lms/saveprogram";
	public static final String PostBatch_URL = "https://lms-backend-service.herokuapp.com/lms/batches";

	public static final String GetAllBatch_URL = "https://lms-backend-service.herokuapp.com/lms/batches";
	public static final String GetSingleBatch_URL = "https://lms-backend-service.herokuapp.com/lms/batches/batchId";
	public static final String GetSingleBatchName_URL = "https://lms-backend-service.herokuapp.com/lms/batches/batchName";
	public static final String GetBatchByProgramId_URL = "https://lms-backend-service.herokuapp.com/lms/batches/program";

	public static final String DeleteProgram_URL = "https://lms-backend-service.herokuapp.com/lms/deletebyprogid";
	public static final String DeleteBatch_URL = "https://lms-backend-service.herokuapp.com/lms/batches";
	
	

	public static final String EXCEL = "./Data Files/LMSAPIHackathonData.xlsx";
	
	
	public static final String BASE_Invalid_URL = "https://lms-backend.herokuapp.com/lms";
	
	public static final String Valid_BatchPut = "/batches/2442";
	public static final String Invalid_BatchPut = "/batchessssssss/1456";

	public static final String Invalid_Endpoint_PutProgram = "/putprogrammmmmm/329";
	public static final String Valid_Endpoint_PutProgram = "/putprogram/4421";
	public static final String ProgramId_NotOnServer = "/putprogram/8652";
	
	public static final String ValidEndPoint_ProgramName = "/program/jan23SDET1";
	public static final String InValidEndPoint_ProgramName = "/program/SDET30255696563333333333";
}


