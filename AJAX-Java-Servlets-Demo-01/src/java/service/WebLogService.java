package service;

import dao.PostingDao;
import dao.PostingDaoImp;
import java.util.List;
import model.Posting;

public class WebLogService {

    private static WebLogService instance;
    public static WebLogService getInstance()
    {
        if( instance == null )
        {
            instance = new WebLogService();
        }
        return instance;
    }
    
    private final PostingDao postingDao;

    private WebLogService() {
        postingDao = new PostingDaoImp();
    }

    public void addPosting(final String title, final String text) {
        addPosting( new Posting(title, text) );
    }

    public void addPosting(Posting p) {
        postingDao.create(p);
    }

    public void updatePosting(Posting p) {
        postingDao.update(p);
    }

    public List<Posting> getPostings() {
        return postingDao.findAll();
    }
    
    public Posting getPost(long id) 
    {
        return postingDao.find(id);
    }
}
