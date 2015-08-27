//package tobySpring;
//
//
//public class DaoFactory {
//	
//	public UserDAO userDAO(){
//		return new UserDAO(connectionMaker());
//	}
//	
//	// 다른 DAO가 추가되어도 connectionMaker를 직접 지정할 필요 없이 connectionMaker() 메서드를 통해 받는다.
//	
////	public AccountDAO accountDAO(){
////		return new AccountDAO(connectionMaker());
////	}
////	
////	public MessageDAO messageDAO(){
////		return new MessageDAO(connectionMaker());
////	}
//	
//	public ConnectionMaker connectionMaker(){
//		return new DConnectionMaker();
//	}
//}
